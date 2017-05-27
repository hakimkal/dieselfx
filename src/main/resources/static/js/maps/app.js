
// Style credit: https://snazzymaps.com/style/1/pale-dawn
const mapStyle = [
  {
    "featureType": "administrative",
    "elementType": "all",
    "stylers": [
      {
        "visibility": "on"
      },
      {
        "lightness": 33
      }
    ]
  },
  {
    "featureType": "landscape",
    "elementType": "all",
    "stylers": [
      {
        "color": "#f2e5d4"
      }
    ]
  },
  {
    "featureType": "poi.park",
    "elementType": "geometry",
    "stylers": [
      {
        "color": "#c5dac6"
      }
    ]
  },
  {
    "featureType": "poi.park",
    "elementType": "labels",
    "stylers": [
      {
        "visibility": "on"
      },
      {
        "lightness": 20
      }
    ]
  },
  {
    "featureType": "road",
    "elementType": "all",
    "stylers": [
      {
        "lightness": 20
      }
    ]
  },
  {
    "featureType": "road.highway",
    "elementType": "geometry",
    "stylers": [
      {
        "color": "#c5c6c6"
      }
    ]
  },
  {
    "featureType": "road.arterial",
    "elementType": "geometry",
    "stylers": [
      {
        "color": "#e4d7c6"
      }
    ]
  },
  {
    "featureType": "road.local",
    "elementType": "geometry",
    "stylers": [
      {
        "color": "#fbfaf7"
      }
    ]
  },
  {
    "featureType": "water",
    "elementType": "all",
    "stylers": [
      {
        "visibility": "on"
      },
      {
        "color": "#acbcc9"
      }
    ]
  }
];

function initMap() {

  // Create the map.
  const map = new google.maps.Map(document.getElementsByClassName('map')[0], {
    zoom: 7,
    center: {lat: 8.9667189, lng: -0.3674982},
    styles: mapStyle
  });

  // Load the stores GeoJSON onto the map.
  map.data.loadGeoJson('../js/maps/stores.json');

  // Define the custom marker icons, using the store's "category".
  map.data.setStyle(feature => {
    return {
      icon: {
        url: `../img/icon_${feature.getProperty('category')}.png`,
        scaledSize: new google.maps.Size(64, 64)
      }
    };
  });

  const apiKey = 'AIzaSyDGy57v-ftVJfU03inWJ3hqmJ5WRPDyka8';
  const infoWindow = new google.maps.InfoWindow();

  // Show the information for a store when its marker is clicked.
  map.data.addListener('click', event => {

    var category = event.feature.getProperty('category');
    var name = event.feature.getProperty('name');
    var description = event.feature.getProperty('description');
    var hours = event.feature.getProperty('hours');
    var phone = event.feature.getProperty('phone');
    var position = event.feature.getGeometry().get();
    var content = `<img style="float:left; width:200px; margin-top:30px" src="../img/logo_${category}.png">
      <div style="margin-left:220px; margin-bottom:20px;">
        <h2>${name}</h2><p>${description}</p>
        <p><b>Price:</b> ${hours}<br/><b>Phone:</b> ${phone}</p>
        <p><img src="https://maps.googleapis.com/maps/api/streetview?size=350x120&location=${position.lat()},${position.lng()}&key=${apiKey}"></p>
      </div>`;

    infoWindow.setContent(content);
    infoWindow.setPosition(position);
    infoWindow.setOptions({pixelOffset: new google.maps.Size(0, -30)});
    infoWindow.open(map);
  });

}
