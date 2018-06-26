<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 5/17/18
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    /* Always set the map height explicitly to define the size of the div
     * element that contains the map. */
    #map {
        height: 60%;
        width: 100%;
    }
</style>

<script>
    var directionsService;
    var directionsDisplay;

    function initMap() {
        directionsService = new google.maps.DirectionsService;
        directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 10,
            center: {lat: 53.860891, lng:27.556278}
        });
        directionsDisplay.setMap(map);
    }

    function calcHandler(end) {
        calculateAndDisplayRoute(directionsService, directionsDisplay,end);
    }

    function calculateAndDisplayRoute(directionsService, directionsDisplay,end) {
        directionsService.route({
            origin: {lat: 53.860891, lng: 27.5562787},
            destination: String(end),
            travelMode: 'DRIVING'
        }, function(response, status) {
            if (status === 'OK') {
                directionsDisplay.setDirections(response);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCXFeBEemk9YTRGjo63OHkw4DiWeF8BVg0&callback=initMap">
</script>

<h2>Карта</h2>
<div id="map"></div>