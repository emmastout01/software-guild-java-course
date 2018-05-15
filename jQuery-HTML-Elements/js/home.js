$(document).ready(onReady());

function onReady() {
    // Center all H1 elements
    $('h1').css('text-align', 'center');

    // Center all H2 elements
    $('h2').css('text-align', 'center');

    // Replace the class that is on the element containing the text “Team Up!” with the class page-header
    $('.myBannerHeading').addClass('page-header');
    $('.myBannerHeading').removeClass('myBannerHeading');

    // Change the text of “The Squad” to “Yellow Team”
    $('#yellowHeading').text('Yellow Team');

    // Change the background color for each team list to match the name of the team
    function changeBackgroundColor(teamColor) {
        $('#' + teamColor + 'TeamList').css('background-color', teamColor);
    }
    changeBackgroundColor('red');
    changeBackgroundColor('orange');
    changeBackgroundColor('yellow'); 
    changeBackgroundColor('blue');


    // Add Joseph Banks and Simon Jones to the Yellow Team list
    $('#yellowTeamList').append('<li>Joseph Banks</li>');
    $('#yellowTeamList').append('<li>Simon Jones</li>');

    // Hide the element containing the text “Hide Me!!!”
    $('#oops').hide();

    // Remove the element containing the text “Bogus Contact Info” from the footer
    $('#footerPlaceholder').hide();

    // Add a paragraph element containing your name and email to the footer. The text must be in Courier font and be 24 pixels in height 
    $('#footer').append('<p id="myContactInfo">Talula Banks  talula.banks@fakegmail.com</p>');
    $('#myContactInfo').css('font-family', 'Courier');
    $('#myContactInfo').css('font-height', '24px');
    $('#myContactInfo').css('text-align', 'center');

}
