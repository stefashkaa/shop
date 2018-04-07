<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <c:import url="fragments/head.jsp" />
  <body>
    <c:import url="fragments/header.jsp" />
    <div id="all">
      <div id="content">
        <div class="container">
          <div class="row">

            <div class="col-sm-4 col-sm-offset-4">
              <c:if test="${not empty errors}">
                <div id="error" class="alert alert-danger alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <c:forEach var="error" items="${errors}">
                    <i class="icon fa fa-exclamation-circle"></i> ${error}
                    <br />
                  </c:forEach>
                </div>
              </c:if>

              <div class="box">
                <h4 class="text-center">Create new account</h4>
                <form action="register.html" method="POST">
                  <div class="form-group">
                    <label>Name</label> <span class="require">(*)</span>
                    <input type="text" class="form-control" name="name">
                  </div>
                  <div class="form-group">
                    <label>Email</label> <span class="require">(*)</span>
                    <input type="text" class="form-control" name="email">
                  </div>
                  <div class="form-group">
                    <label>Password</label> <span class="require">(*)</span>
                    <input type="password" class="form-control" name="password">
                  </div>
                  <div class="form-group">
                    <label for="password">Confirm Password</label> <span class="require">(*)</span>
                    <input type="password" class="form-control" name="confirmPassword">
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary" name="register"><i class="fa fa-client-md"></i> Register</button>
                  </div>
                </form>
              </div>
            </div>

          </div>
        </div>
      </div>
      <c:import url="fragments/footer.jsp" />
    </div>
    <c:import url="fragments/scripts.jsp" />
  </body>
</html>