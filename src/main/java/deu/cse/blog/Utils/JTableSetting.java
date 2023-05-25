/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.cse.blog.Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author 조은진
 */
public class JTableSetting {

    /**
     * 테이블 기본 디자인 세팅
     *
     * @param jScrollPane
     * @param jTable
     */
    public static void tableInit(JScrollPane jScrollPane, JTable jTable) {
        /* 스크롤 패널 배경 색상 변경 */
        jScrollPane.setBackground(new Color(255, 255, 255, 0));
        jScrollPane.getViewport().setOpaque(false);

        /* 테이블 UI, 테이블 헤더 UI 변경 */
        jTable.setUI(new BasicTableUI());

        /* 테이블 배경 색상 변경 */
        JTableSetting.setTableBackground(jTable, new Color(255, 255, 255, 255));
        jTable.setOpaque(true);
        jTable.setBorder(null);

    }

    /**
     * 테이블 기본 헤더 디자인 세팅
     *
     * @param jTable
     * @param width
     * @param tableHeight
     */
    public static void tableHeaderInit(JTable jTable, int width, int tableHeight) {
        /* 테이블 헤더 색상, UI, 글자색 변경 */
        JTableHeader tbh = jTable.getTableHeader();

        tbh.setUI(new BasicTableHeaderUI());
        tbh.setOpaque(false);                             // Opaque(투명도) 를 false로 해줘야 색상 적용됨
        tbh.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));

        tbh.setPreferredSize(new Dimension(width, tableHeight));
        tbh.setBackground(new Color(255, 255, 255));            // 테이블 헤더의 배경색 설정
        tbh.setForeground(new Color(0, 0, 0));            // 테이블 헤더의 글자색 설정

        /* 테이블 헤더 테두리 설정 */
        MatteBorder border = new MatteBorder(2, 0, 2, 0, new Color(248, 248, 248));
        tbh.setBorder(border);
    }

    /**
     * 테이블 배경 색상 변경 메소드
     *
     * @param jTable
     * @param color
     */
    public static void setTableBackground(JTable jTable, Color color) {
        jTable.setFillsViewportHeight(true);
        jTable.setBackground(color);
        jTable.setOpaque(false);
    }

    /**
     * 테이블에 여러 값을 한 번에 추가하는 메소드
     *
     * @param tableModel
     * @param values
     */
    public static void insertTableRow(DefaultTableModel tableModel, Object[][] values) {
        for (Object[] value : values) {
            tableModel.insertRow(tableModel.getRowCount(), value);
        }
    }

    /**
     * 테이블의 셀(컬럼)의 크기를 변경하는 메소드
     *
     * @param jTable
     * @param width
     */
    public static void setTableCellSize(JTable jTable, int[] width) {
        TableColumnModel model = jTable.getColumnModel();

        for (int i = 0; i < model.getColumnCount(); i++) {
            model.getColumn(i).setPreferredWidth(width[i]);
        }
    }

    /**
     * 테이블에 하나의 값을 추가하는 메소드
     *
     * @param tableModel
     * @param value
     */
    public static void insertTableRow(DefaultTableModel tableModel, Object[] value) {
        tableModel.insertRow(tableModel.getRowCount(), value);
    }

    // 리스트를 출력하는 테이블은 이 디자인을 적용
    public static void listTableSetting(JTable jTable) {
        /* 테이블 셀 사이즈 변경 */
        setTableCellSize(jTable, new int[]{100, 600, 100, 100});

        /* 테이블 컬럼 중앙 정렬 */
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
        dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

        TableColumnModel tableColumnModel = jTable.getColumnModel();
        tableColumnModel.getColumn(0).setCellRenderer(dtcr);
        tableColumnModel.getColumn(3).setCellRenderer(dtcr);
    }

}
