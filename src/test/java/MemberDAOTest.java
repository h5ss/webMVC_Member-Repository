import com.ssg.webmvc_memberrepository.dao.ConnectionUtil;
import com.ssg.webmvc_memberrepository.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOTest {

    @Test
    public void listAllMembers() throws Exception {
        String sql = "select * from mvc_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> memberVOList = new ArrayList<>();
        while (rs.next()){
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .memail(rs.getString("memail"))
                    .joindate(rs.getDate("joindate").toLocalDate())
                    .build();
            memberVOList.add(vo);
        }
        memberVOList.forEach(System.out::println);

    }

    @Test
    public void selectOneTest() throws Exception{
        String sql = "select * from mvc_member where mid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,"ki");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        MemberVO vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .memail(rs.getString("memail"))
                .build();

        System.out.println(vo.toString());
    }
}
