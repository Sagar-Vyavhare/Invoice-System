<%@include file="Header.jsp" %>
<script>
    $(document).ready(function () {
        Getallcustomers();
        $("#btnsubmit").click(function () {
            $("#btnsubmit").prop('disabled', true);
            Addcustomer();
        })
        $("#btnaddcudtomer").click(function () {
            $("#btnsubmit").prop('disabled', false);
            $("#customermodal").modal("show");
        })
    })
    function deletcust(id) {
        console.log("sagar");
        $.ajax({
            url: 'http://localhost:9090/api/customerbyid?id=' + id,
            method: 'delete',
            contentType: 'application/json',
            success: function (resp) {
                Getallcustomers();
                alert("customer deleted");
            }

        })
    }
    function Getallcustomers() {
        $.ajax({
            url: 'http://localhost:9090/api/customer',
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#tbldata").empty();
                $.each(resp, function (i, d) {
                    $("#tbldata").append("<tr><td>" + (i + 1) + "</td><td>" + d.customer_name + "</td><td>" + d.city + "</td><td>" + d.email + "</td><td>" + d.mobile_number + "</td><td><input type='button' class='btn btn-danger btn-xs' value='delete' onclick='deletcust(" + d.customer_id + ")'></td></tr>");
                })
            }

        })
    }
    function Addcustomer() {
        var name = $("#customer_name").val();
        var city = $("#city").val();
        var email = $("#email").val();
        var m_number = $("#mobile_number").val();
        var obj = {"customer_name": name, "city": city, "email": email, "mobile_number": m_number};
        $.ajax({
            url: 'http://localhost:9090/api/customer',
            method: 'post',
            data: JSON.stringify(obj),
            contentType: 'application/json',
            success: function (resp) {
                Getallcustomers();
                $("#customermodal").modal("hide");
                document.getElementById("alert").style.display = "block";
                $("#customer_name").val("");
                $("#city").val("");
                $("#email").val("");
                $("#mobile_number").val("");
            }

        })
    }

</script>
<h2>Customer</h2>
<p class="alert alert-success" id="alert" style="display:none;">Customer added</p>
<input type="button" value="form" id="btnaddcudtomer" class="btn btn-primary">
<div class="modal fade" id="customermodal">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" data-dismiss="modal" class="close"><span>&times;</span></button>
                <h4>Customer Form</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Customer Id</label>
                            <input type="text" id="customer_id" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Customer name</label>
                            <input type="text" id="customer_name" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>City</label>
                            <input type="text" id="city" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="text" id="email" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Mobile Number</label>
                            <input type="text" id="mobile_number" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <input type="button" value="Submit" id="btnsubmit" class="btn btn-primary" disabled>
                <input type="button" class="btn btn-warning" data-dismiss="modal" value="close">
            </div>
        </div>
    </div>
</div>
<table class="table table-bordered">
    <thead>
        <tr class="success">
            <td>Customer Id</td>
            <td>Customer Name</td>
            <td>City</td>
            <td>Email</td>
            <td>Mobile Number</td>
            <td>Action</td>
        </tr>
    </thead>
    <tbody id="tbldata">

    </tbody>
</table>
</div>

<%@include file="Footer.jsp" %>