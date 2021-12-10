<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/car-park/booking-office" />
<c:url var="NewURL" value="/car-park/booking-office/list" />
        <html>

        <head>
            <title>Add Booking office</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>
            <!-- Right content  -->
            <!-- Add profile  -->
            <div class="col-sm-9">
                <h2 class="pt-3">Add Booking office</h2>
                <hr class="border">
                <div class="row">
                    <div class="col-sm-3 flex-row">
                        <div>
                            <label class="m-2"><b>Booking office name <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Trip <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Phone number <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Place <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Price <span class="text-danger">(*)</span></b></label>
                        </div>
                        <div>
                            <label class="m-2"><b>Contract deadline <span class="text-danger">(*)</span></b></label>
                        </div>
                    </div>
                    <div class="col-sm-6 flex-row">
                        <form id="formSubmit">
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="officeName" id="officeName" placeholder="Enter booking office name" value="${model.officeName}">
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="tripId" id="tripId">
                                    <c:forEach var="item" items="${trips}">
                                        <option value="${item.tripId}">${item.destination}</option>>
                                    </c:forEach>>
<%--                                    <option value="1">Hà Giang</option>--%>
<%--                                    <option value="2">Lào Cai</option>--%>
                                </select>
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="officePhone" id="officePhone" placeholder="Enter phone number" value="${model.officePhone}">
                            </div>
                            <div>
                                <select class="p-1 m-1 border rounded" name="officePlace" id="officePlace">
                                    <option value="Quầy số 1">Quầy số 1</option>
                                    <option value="Quầy số 2">Quầy số 2</option>
                                </select>
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="text" name="officePrice" id="officePrice" placeholder="Enter price" value="${model.officePrice}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="date" name="startContractDate" id="startContractDate" value="${model.startContractDate}">
                            </div>
                            <div>
                                <input class="p-1 m-1 border rounded" type="date" name="endContractDate" id="endContractDate" value="${model.endContractDate}">
                            </div>
                        </form>

                    </div>
                </div>
                <div class="row ">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div onclick="goBack()" class="btn btn-info p-1 m-1"><i class="fas fa-backward"></i> Back</div>
                        <div onclick="resetInput()" class="btn btn-warning text-white p-1 m-1"><i class="fas fa-undo-alt"></i> Reset</div>
                        <c:if test="${not empty model.officeId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Update</div>
                        </c:if>
                        <c:if test="${empty model.officeId}">
                            <div onclick="addOrUpdateData()" id="addEmployee" class="btn btn-success p-1 m-1"><i class="fas fa-plus"></i> Add</div>
                        </c:if>
                    </div>
                    <input type="hidden" value="${model.officeId}" id="id" name="id" />
                </div>
            </div>
            </div>
            <script>
                function addOrUpdateData() {
                    var data = {};
                    data["officeName"] = $('#officeName').val()
                    data["tripId"] = $('select#tripId').children("option:selected").val()
                    data["officePhone"] = $('#officePhone').val()
                    data["officePlace"] = $('select#officePlace').children("option:selected").val()
                    data["officePrice"] = $('#officePrice').val()
                    var startDate = $('#startContractDate').val()
                    data["startContractDate"] = moment(startDate, 'YYYY-MM-DD').format("YYYY-MM-DD");
                    var endDate = $('#endContractDate').val()
                    data["endContractDate"] = moment(endDate, 'YYYY-MM-DD').format("YYYY-MM-DD");

                  var checkData = []
                  $.each(data, function(index, value) {
                    checkData.push(value)
                  })
                    console.log(checkData)
                  if ($.inArray("", checkData) >= 0 || $.inArray(undefined, checkData) >= 0 || $.inArray("Invalid date", checkData) >= 0) {
                    alert("Please insert full information!")
                  } else {
                    var id = $('#id').val();
                    if (id == "") {
                        console.log(data)
                      addNew(data)
                    } else {
                      data["officeId"] = id
                        console.log(data)
                      updateNew(data)
                    }
                  }
                }

                function addNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            <%--window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";--%>
                            window.location.href = "${NewURL}?page=1&limit=2"
                        },
                        error: function(error) {
                            <%--window.location.href = "${NewURL}?page=1&limit=2&message=error_system";--%>
                        }
                    });
                }

                function updateNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            <%--window.location.href = "${NewURL}?type=edit&id=" + result.officeId + "&message=update_success";--%>
                            <%--window.location.href = "${NewURL}?page=1&limit=2"--%>
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?page=1&limit=2&message=error_system";
                        }
                    });
                }

                function resetInput() {
                    $('#officeName').val(null)
                    $('select#tripId').children("option:selected").val(null)
                    $('#officePhone').val(null)
                    $('select#officePlace').children("option:selected").val(null)
                    $('#officePrice').val(null)
                    $('#startContractDate').val(null)
                    $('#endContractDate').val(null)
                }

                function goBack() {
                    window.history.back();
                }
            </script>
        </body>

        </html>