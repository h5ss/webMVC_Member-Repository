package com.ssg.webmvc_memberrepository.dao;

import com.ssg.webmvc_memberrepository.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public List<MemberVO> listMembers() throws Exception {
        String sql = "select * from mvc_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> memberVOList = new ArrayList<>();
        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .memail(rs.getString("memail"))
                    .joindate(rs.getDate("joindate").toLocalDate())
                    .build();
            memberVOList.add(vo);
        }

        return memberVOList;
    }

    public void insert(MemberVO vo) throws Exception {
        String sql = "insert into mvc_member(mid, mpw, mname, memail, joindate) values(?,?,?,?,now())";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, vo.getMid());
        pstmt.setString(2, vo.getMpw());
        pstmt.setString(3, vo.getMname());
        pstmt.setString(4, vo.getMemail());
        pstmt.executeUpdate();
    }

    public void modify(MemberVO vo) throws Exception {
        String sql = "update mvc_member set mpw = ?, mname = ?, memail = ? where mid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, vo.getMpw());
        pstmt.setString(2, vo.getMname());
        pstmt.setString(3, vo.getMemail());
        pstmt.setString(4, vo.getMid());

        pstmt.executeUpdate();
    }
    public MemberVO selectOne(String mid) throws Exception{
        String sql = "select * from mvc_member where mid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,mid);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        return MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .memail(rs.getString("memail"))
                .build();
    }
    public void deleteOne(String mid) throws Exception{
        String sql = "delete from mvc_member where mid = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,mid);

        pstmt.executeUpdate();
    }

    public MemberVO login(String mid, String mpw) throws Exception {
        String sql = "select * from mvc_member where mid = ? and mpw = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,mid);
        pstmt.setString(2,mpw);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        return MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .memail(rs.getString("memail"))
                .joindate(rs.getDate("joindate").toLocalDate())
                .build();
    }
}
