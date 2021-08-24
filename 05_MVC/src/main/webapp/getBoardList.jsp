<%@page import="com.yydh.model.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="EUC-KR">
        <title>글 목록</title>
    </head>

    <body>
        <center>
            <h1>글 목록</h1>
            <h3>
                테스트님 환영합니다... <a href="logout.do">Log-out</a>
            </h3>
            <!--검색 시작-->
            <form action="getBoardList.do" method="post">
                <table border="1" cellpadding="0" cellspacing="0" width="700">
                    <tr>
                        <td align="right">
                            <select name="searchCondition">
                                <option value="TITLE">제목</option>
                                <option value="CONTENT">내용</option>
                            </select>
                            <input type="text" name="searchKeyword">
                            <input type="submit" value="검색">
                        </td>
                    </tr>
                </table>
            </form>
            <!--검색 종료-->

            <!-- 게시물 시작-->
            <table border="1" cellpadding="0" cellspacing="0" width="700">
                <tr>
                    <th bgcolor="orange" width="100">번호</th>
                    <th bgcolor="orange" width="200">제목</th>
                    <th bgcolor="orange" width="150">작성자</th>
                    <th bgcolor="orange" width="150">등록일</th>
                    <th bgcolor="orange" width="100">조회수</th>
                </tr>
                <!--JSP 문법-->
                <c:forEach items="${boardList}" var="board">
                	<tr>
                    	<td>${board.seq}</td>
                    	<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
                    	<td>${board.writer}</td>
                    	<td>${board.regDate}</td>
                    	<td>${board.cnt}</td>
                	</tr>
                </c:forEach>
            </table>
            <br/>
            <a href="insertBoard.jsp">새 글 등록</a>
        </center>

    </body>

    </html>