<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>班级管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>

</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">班级管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-hover table-bordered">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>所属标签</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${clazzes}" var="clazz">
                    <c:if test="${not empty clazz.id}">
                        <tr>
                            <td>${clazz.id}</td>
                            <td>${clazz.name}</td>
                            <td>${clazz.tagname}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/t-clazz/deletebyid?id=${clazz.id}" class="btn btn-danger">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <form id="inputForm" class="form-inline" action="${pageContext.request.contextPath}/t-clazz/save" method="post">
                <div class="form-group">
                    <label for="name">名称:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="tagname">选择对应标签:</label>
                    <select name="tagname" id="tagname" class="form-control">
                        <c:forEach items="${clazzes}" var="clazz">
                            <option id="${clazz.tagname}">${clazz.tagname}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">添加班级</button>
            </form>
        </div>
    </div>

</div>

</body>

<script>
    $(function(){
        //添加是班级名称非空验证
        $("#inputForm").submit(function(){

            if (!$("#name").val()) {
                alert('请输入班级名称!!!');
                return false;
            }

            return true;
        });

    })
</script>