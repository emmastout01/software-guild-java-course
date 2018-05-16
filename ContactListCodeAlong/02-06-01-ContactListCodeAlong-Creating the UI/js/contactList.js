$(document).ready(onReady);

function onReady() {
    loadContacts();
    $('#add-button').on('click', addContact);
    $('#edit-button').on('click', editContact);
}

function loadContacts() {
    var contentRows = $('#contentRows');
    contentRows.empty();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/contacts',
        //The parameter in the 'success' function is the response from the server. We're calling it 'contactArray'
        success: function (contactArray) {
            //Jquery 'each' function. We're going through each entry. First param is the array, second param is function to run on each item
            //First param of processing function is index, second is the actual thing we're grabbing out
            $.each(contactArray, function (index, contact) {
                var name = contact.firstName + ' ' + contact.lastName;
                var company = contact.company;
                var contactId = contact.contactId;

                var row = '<tr>';
                row += '<td>' + name + '</td>';
                row += '<td>' + company + '</td>';
                row += '<td><a onClick="showEditForm(' + contactId + ')">Edit</a></td>';
                row += '<td><a onClick="deleteContact(' + contactId + ')">Delete</a></td>';
                row += '</tr>';

                contentRows.append(row);

            })
        },
        error: function () {
            $('#errorMessages')
                .append($('<li>')
                    .attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service: GET'));
        }
    });
}

function addContact() {

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/contact',
        data: JSON.stringify({
            firstName: $('#add-first-name').val(),
            lastName: $('#add-last-name').val(),
            company: $('#add-company').val(),
            phone: $('#add-phone').val(),
            email: $('#add-email').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'datatype': 'json',
        success: function () {
            $('#errorMessages').empty();
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            loadContacts();
        },
        error: function (error) {
            $('#errorMessages')
                .append($('<li>')
                    .attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service: POST'));
        }
    })
}

function showEditForm(contactId) {
    $('#errorMessages').empty();
    $('#contactTableDiv').hide();
    $('#editFormDiv').show();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/contact/' + contactId,
        success: function (data) {
            $('#edit-first-name').val(data.firstName);
            $('#edit-last-name').val(data.lastName);
            $('#edit-company').val(data.company);
            $('#edit-phone').val(data.phone);
            $('#edit-email').val(data.email);
            $('#edit-contact-id').val(data.contactId);
        },
        error: function (error) {
            $('#errorMessages')
                .append($('<li>')
                    .attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service: POST'));
            console.log(error);
        }
    })


}

function editContact() {
    var contactId = $('#edit-contact-id').val();
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/contact/' + contactId,
        data: JSON.stringify({
            firstName: $('#edit-first-name').val(),
            lastName: $('#edit-last-name').val(),
            company: $('#edit-company').val(),
            phone: $('#edit-phone').val(),
            email: $('#edit-email').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'datatype': 'json',
        success: function () {
            hideEditForm();
            loadContacts();
        },
        error: function (error) {
            $('#errorMessages')
                .append($('<li>')
                    .attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service: POST'));
            console.log(error);
        }
    })
}

function hideEditForm() {
    $('#errorMessages').empty();

    $('#edit-first-name').val('');
    $('#edit-last-name').val('');
    $('#edit-company').val('');
    $('#edit-phone').val('');
    $('#edit-email').val('');

    $('#contactTableDiv').show();
    $('#editFormDiv').hide();
}

function deleteContact(contactId) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/contact/' + contactId,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function () {
            loadContacts();
        },
        error: function (error) {
            $('#errorMessages')
                .append($('<li>')
                    .attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service: POST'));
            console.log(error);
        }
    })
}

