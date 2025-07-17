package koreaIT.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import koreaIT.util.DBUtil;
import koreaIT.util.SecSql;

@WebServlet("/article/deleteV2")
public class ArticleDeleteServletV2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Connection conn = null;

        try {
            // 데이터베이스 연결 설정
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/AM_jsp_2025_07?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
            conn = DriverManager.getConnection(url, "root", "");

            // 삭제할 게시글 ID 파라미터 받기
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                response.getWriter().append("<script>alert('유효하지 않은 게시물 번호입니다.'); history.back();</script>");
                return;
            }

            // 삭제 SQL 실행
            SecSql sql = new SecSql();
            sql.append("DELETE FROM `article`");
            sql.append("WHERE `id` = ?", id);

            int affectedRows = DBUtil.delete(conn, sql);

            // 삭제 결과에 따른 처리
            if (affectedRows > 0) {
                // 삭제 성공 시 목록 페이지로 리다이렉트
                response.getWriter().append(String.format("<script>alert('%d번 게시물이 삭제되었습니다.'); location.replace('list');</script>", id));
            } else {
                // 삭제 실패 시 (해당 id의 게시물이 없는 경우 등)
                response.getWriter().append(String.format("<script>alert('%d번 게시물 삭제에 실패했습니다.'); history.back();</script>", id));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패: " + e);
            response.getWriter().append("<script>alert('데이터베이스 드라이버 로딩에 실패했습니다.'); history.back();</script>");
        } catch (SQLException e) {
            System.out.println("SQL 에러: " + e);
            response.getWriter().append("<script>alert('데이터베이스 작업 중 오류가 발생했습니다.'); history.back();</script>");
        } finally {
            // 데이터베이스 연결 자원 해제
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}