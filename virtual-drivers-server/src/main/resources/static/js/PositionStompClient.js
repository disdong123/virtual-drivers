class PositionStompClient {
  _stompClient;
  constructor(map, markers) {
    this._stompClient = new StompJs.Client({
      brokerURL: 'ws://localhost:8080/api/virtual-drivers',
    });

    this._stompClient.onConnect = (frame) => {
      this._stompClient.subscribe(
        '/driving-direction/position',
        function (data) {
          // 한번에 넘어오면 아래처럼 처리합니다.
          // https://github.com/disdong123/virtual-drivers/commit/b1d9980418b23e428d2822d808ea291154a38e0f#diff-a9f4db23c5e5627de6755466051cf7381fe40678f7e1c781f3ba6d3170e299d3
          const response = JSON.parse(data.body);
          if (response === undefined || response === null) {
            return;
          }

          const marker = markers.find(
            (marker) => marker.title === response.directionId,
          );
          if (marker) {
            marker.setMap(null);
            markers.splice(markers.indexOf(marker), 1);
          }

          markers.push(
            map.createMarker(response.position, response.directionId),
          );
        },
      );
    };

    this._stompClient.onWebSocketError = function (event) {
      console.log('Error: ' + JSON.stringify(event));
    };

    this._stompClient.onStompError = (frame) => {
      console.error('Broker reported error: ' + frame.headers['message']);
      console.error('Additional details: ' + frame.body);
    };
  }

  activate = () => {
    this._stompClient.activate();
  };

  deactivate = () => {
    this._stompClient.deactivate();
  };
}
