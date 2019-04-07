 $(document).ready(function () {  
	 /*
		Checking the weather on button go
		{.check-weather} name can vary depending on the class given to the html button.
	 */
    $('.check-weather').click(function(){

       var city = $('.city-input').val();
		
		/*URL along with the api appended with makes a http call and returns the json format.
		  It takes &q="city-name"  as parameter in url
		*/
		var url = "https://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=943e243002779f0d9b429bc358e6af2c";
	
		/*
			getJSON : This is a shorthand Ajax function, Data that is sent to the server is appended to the URL as a query string. 
			If the value of the data parameter is a plain object, it is converted to a string and url-encoded before it is appended to the URL.
			@param : url(data sent to server)
					 Function that takes the json returned by the server and used to decode it.


		*/
    $.getJSON(url, function (json) {
        
		/*
			Get the city name and country from the json data.
		*/
        window.alert(json.city.name);
		window.alert(json.city.country);

       /*
		Example of the json parsing that can be used to parse the temperature returned.
		JSON.stringify() : turns a JavaScript object into JSON text and stores that JSON text in a string.

		NOTE:     The temperaturw returned by the openweather api is in kelvin
			      Converting kelvin to celsius is easy: Just subtract 273.15.
			      But the brief glancing at the documentation provived append &unit=metric to get the temperature in celsius.
		EXAMPLE:
				  http://api.openweathermap.org/data/2.5/forecast?q=mumbai&APPID=943e243002779f0d9b429bc358e6af2c&units=metric
	
	
	   */
        
        window.alert(JSON.stringify(Math.round(json.list[0].main.temp-273.15)));
        
       
        
		});
	});