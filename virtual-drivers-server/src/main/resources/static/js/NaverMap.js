class NaverMap {
  _map;
  constructor(options) {
    this._map = new naver.maps.Map('map', {
      center: new naver.maps.LatLng(37.3595704, 127.105399),
      zoom: 10,
    });
  }

  setCenterWithAddress = (address, type, markers) => {
    fetch(
      `http://localhost:8080/api/v1/translation/address?address=${address}&translationType=POSITION`,
      {
        method: 'GET',
      },
    )
      .then((response) => response.json())
      .then((data) => {
        if (data.code !== 200) {
          console.log(data.message);
          return;
        }

        console.log(
          `latitude: ${data.data.latitude}, longitude: ${data.data.longitude}`,
        );

        markers.find((marker) => marker.title === type)?.setMap(null);
        this.createMarker(
          {
            latitude: data.data.latitude,
            longitude: data.data.longitude,
          },
          type,
        );

        this._map.setCenter(
          new naver.maps.LatLng(data.data.latitude, data.data.longitude),
        );

        switch (type) {
          case 'start':
            startPosition = {
              address: address,
              latitude: data.data.latitude,
              longitude: data.data.longitude,
            };
            break;
          case 'end':
            endPosition = {
              address: address,
              latitude: data.data.latitude,
              longitude: data.data.longitude,
            };
            break;
        }
      })
      .catch((error) => console.log(error));
  };

  getDirection = (startPosition, endPosition) => {
    fetch(
      `http://localhost:8080/api/v1/driving-direction?startAddress=${startPosition.address}&startLatitude=${startPosition.latitude}&startLongitude=${startPosition.longitude}&endAddress=${endPosition.address}&endLatitude=${endPosition.latitude}&endLongitude=${endPosition.longitude}`,
      {
        method: 'GET',
      },
    )
      .then((response) => response.json())
      .then((data) => {
        if (data.code !== 200) {
          console.log(data.message);
          return;
        }

        new naver.maps.Polyline({
          map: this._map,
          path: data.data.route.map(
            (route) => new naver.maps.LatLng(route.latitude, route.longitude),
          ),
        });
      });
  };

  createMarker = (position, title) => {
    return new naver.maps.Marker({
      position: new naver.maps.LatLng(position.latitude, position.longitude),
      title: title,
      map: this._map,
    });
  };
}
