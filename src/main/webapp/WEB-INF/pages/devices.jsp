<%--
  Created by IntelliJ IDEA.
  User: Maciek
  Date: 04.01.14
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
    <c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
    <link href="http://www.jtable.org/Scripts/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
    <link href="http://www.jtable.org/Content/themes/metroblue/jquery-ui.css" rel="stylesheet" type="text/css" />

    <script src="http://www.jtable.org/Scripts/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="http://www.jtable.org/Scripts/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
    <script src="http://www.jtable.org/Scripts/jtable/jquery.jtable.js" type="text/javascript"></script>

    <script>


        $(function() {
            $( "#datepicker" ).datepicker();
        });
    </script>

</head>
<body>

<p>Date: <input type="text" id="datepicker"></p>

<script>

    //Localization texts
    var polishMessages = {
        serverCommunicationError: ' Wyjebało się',
        loadingMessage: 'Ładuje ...',
        noDataAvailable: 'Brak danych',
        addNewRecord: '<spring:message code="label"/>',
        editRecord: 'Edytuj',
        areYouSure: 'Czy jesteś pewien?',
        deleteConfirmation: 'Czy jesteś pewien że chcesz usunąć wpis?',
        save: 'Zapisz',
        saving: 'Zapisuje',
        cancel: 'Anuluj',
        deleteText: 'Usuń',
        deleting: 'Usuwam',
        error: 'Błąd',
        close: 'Zamknij',
        cannotLoadOptionsFor: '{0} Nie udało się wykonać operacji!',
        pagingInfo: 'Showing {0}-{1} of {2}',
        canNotDeletedRecords: '{1} kayıttan {0} adedi silinemedi!',
        deleteProggress: '{1} kayıttan {0} adedi silindi, devam ediliyor...'
    };




    $(document).ready(function() {
        //setup the jtable that will display the results
        $('#ExpenseTableContainer').jtable({
            messages : polishMessages,
            title: 'Table of Expenses',
            selecting: true, //Enable selecting
            paging: true, //Enable paging
            pageSize: 10, //Set page size (default: 10)
            sorting: true, //Enable sorting
            actions: {
                listAction: '${baseURL}/devices/datatable/getAllDevices',
                createAction: '${baseURL}/devices/datatable/addDevice',
                updateAction: '${baseURL}/devices/datatable/updateDevice',
                deleteAction: '${baseURL}/devices/datatable/deleteDevice'
            },
            fields: {
                id: {
                    title: 'id',
                    key: true,
                    list: true,
                    create: false,
                    edit: false
                },
                creationDate: {
                    title: '<spring:message code="label"/>',
                    width: '30%',
                    input: function (data) {
                        var dt = data.record ? data.record.creationDate : '';
                        return '<input  type="text" style="width:200px" value="' + dt + '" />';
                    }
                },
                deviceType: {
                    title: 'Type',
                    options: '${baseURL}/devices/datatable/types'
                },
                description: {
                    title: 'Description',
                    width: '25%'
                },
                name: {
                    title: 'Name',
                    width: '25%'
                }
            },
            rowInserted: function (event, data) {
                //if (data.record.Name.indexOf('Andrew') >= 0) {
                $('#ExpenseTableContainer').jtable('selectRows', data.row);
                console.log("records inserted");
                //$('#PeopleTableContainer').jtable('load');
                //}
            },
            //Register to selectionChanged event to hanlde events
            recordAdded: function(event, data){
                //after record insertion, reload the records
                $('#ExpenseTableContainer').jtable('load');
            },
            recordUpdated: function(event, data){
                //after record updation, reload the records
                $('#ExpenseTableContainer').jtable('load');
            },
            formCreated: function(event,data) {

                    $( "#Edit-creationDate" ).datepicker();

            }


        });
        $('#ExpenseTableContainer').jtable('load');

    });
</script>

<h2>Groups</h2>
<spring:message code="label"/>
<div id="ExpenseTableContainer" style="width:99%;">



</div>
</body>
</html>