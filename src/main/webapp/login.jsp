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
              <c:if test="${not empty error}">
                <div id="error" class="alert alert-danger alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <i class="icon fa fa-exclamation-circle"></i> ${error}
                </div>
                <c:remove var="error" scope="session" />
              </c:if>

              <div class="box">
                <h4 class="text-center">Login to continue</h4>
                <form action="login.html" method="POST">
                  <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" name="email" />
                  </div>
                  <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" />
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary" name="btnLogin">
                      <i class="fa fa-user"></i> Login
                    </button>
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