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
          const responses = JSON.parse(data.body);
          if (responses === []) {
            return;
          }

          markers.forEach((marker) => marker.setMap(null));
          markers = responses.map((response) =>
            map.createMarker(response.position),
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
