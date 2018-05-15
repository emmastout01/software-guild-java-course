$(document).ready(onReady());

function onReady() {
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    displayMain();
    displayMinneapolis();
    displayAkron();
    displayLouisville();
    displayMinneapolisWeather();
    displayAkronWeather();
    displayLouisvilleWeather();
    toggleTableRowOnHover();
}

function displayMain() {
    displaySection('main');
}

function displayMinneapolis() {
    displaySection('minneapolis');
}

function displayAkron() {
    displaySection('akron');
}

function displayLouisville() {
    displaySection('louisville');
}

function displayAkronWeather() {
    toggleWeatherClick('akron');
}

function displayMinneapolisWeather() {
    toggleWeatherClick('minneapolis');
}

function displayLouisvilleWeather() {
    toggleWeatherClick('louisville');
}
   
function displaySection(sectionName) {
    $('#' + sectionName + 'Button').on('click', function() {
     $('#mainInfoDiv').hide();
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#' + sectionName +'InfoDiv').show();
   }) 
}

function toggleWeatherClick(cityName) {
    var weatherButton = '#' + cityName + 'WeatherButton';
    var weatherDisplay = '#' + cityName + 'Weather';
    $(weatherButton).on('click', function() {
        $(weatherDisplay).toggle();
        var message = $(weatherDisplay).is(':visible') ? 'Hide Weather' : 'Show Weather';
        $(weatherButton).text(message);
    })
}

function toggleTableRowOnHover() {
    $('tr').not(':first').hover(function() {
        $(this).css('background-color', 'WhiteSmoke');
    }, function() {
        $(this).css('background-color', 'white');
    })
}