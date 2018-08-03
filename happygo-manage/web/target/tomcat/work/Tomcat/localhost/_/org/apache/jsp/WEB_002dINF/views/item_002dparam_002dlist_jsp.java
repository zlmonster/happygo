/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-25 09:52:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_002dparam_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<table class=\"easyui-datagrid\" id=\"itemParamList\" title=\"商品列表\" \n");
      out.write("       data-options=\"singleSelect:false,collapsible:true,pagination:true,url:'/rest/item/param/list',method:'get',pageSize:30,toolbar:itemParamListToolbar\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("        \t<th data-options=\"field:'ck',checkbox:true\"></th>\n");
      out.write("        \t<th data-options=\"field:'id',width:60\">ID</th>\n");
      out.write("        \t<th data-options=\"field:'itemCatId',width:80\">商品类目ID</th>\n");
      out.write("        \t<th data-options=\"field:'itemCatName',width:100\">商品类目</th>\n");
      out.write("            <th data-options=\"field:'paramData',width:300,formatter:formatItemParamData\">规格(只显示分组名称)</th>\n");
      out.write("            <th data-options=\"field:'created',width:130,align:'center',formatter:HAPPYGO.formatDateTime\">创建日期</th>\n");
      out.write("            <th data-options=\"field:'updated',width:130,align:'center',formatter:HAPPYGO.formatDateTime\">更新日期</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("</table>\n");
      out.write("<div id=\"itemEditWindow\" class=\"easyui-window\" title=\"编辑商品\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'\" style=\"width:80%;height:80%;padding:10px;\">\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("\tfunction formatItemParamData(value , index){\n");
      out.write("\t\tvar json = JSON.parse(value);\n");
      out.write("\t\tvar array = [];\n");
      out.write("\t\t$.each(json,function(i,e){\n");
      out.write("\t\t\tarray.push(e.group);\n");
      out.write("\t\t});\n");
      out.write("\t\treturn array.join(\",\");\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("    function getSelectionsIds(){\n");
      out.write("    \tvar itemList = $(\"#itemParamList\");\n");
      out.write("    \tvar sels = itemList.datagrid(\"getSelections\");\n");
      out.write("    \tvar ids = [];\n");
      out.write("    \tfor(var i in sels){\n");
      out.write("    \t\tids.push(sels[i].id);\n");
      out.write("    \t}\n");
      out.write("    \tids = ids.join(\",\");\n");
      out.write("    \treturn ids;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    var itemParamListToolbar = [{\n");
      out.write("        text:'新增',\n");
      out.write("        iconCls:'icon-add',\n");
      out.write("        handler:function(){\n");
      out.write("        \tHAPPYGO.createWindow({\n");
      out.write("        \t\turl : \"/rest/page/item-param-add\",\n");
      out.write("        \t});\n");
      out.write("        }\n");
      out.write("    },{\n");
      out.write("        text:'编辑',\n");
      out.write("        iconCls:'icon-edit',\n");
      out.write("        handler:function(){\n");
      out.write("        \t$.messager.alert('提示','该功能未实现!');\n");
      out.write("        }\n");
      out.write("    },{\n");
      out.write("        text:'删除',\n");
      out.write("        iconCls:'icon-cancel',\n");
      out.write("        handler:function(){\n");
      out.write("        \tvar ids = getSelectionsIds();\n");
      out.write("        \tif(ids.length == 0){\n");
      out.write("        \t\t$.messager.alert('提示','未选中商品规格!');\n");
      out.write("        \t\treturn ;\n");
      out.write("        \t}\n");
      out.write("        \t$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品规格吗？',function(r){\n");
      out.write("        \t    if (r){\n");
      out.write("        \t    \tvar params = {\"ids\":ids};\n");
      out.write("                \t$.post(\"/rest/item/param/delete\",params, function(data){\n");
      out.write("            \t\t\tif(data.status == 200){\n");
      out.write("            \t\t\t\t$.messager.alert('提示','删除商品规格成功!',undefined,function(){\n");
      out.write("            \t\t\t\t\t$(\"#itemParamList\").datagrid(\"reload\");\n");
      out.write("            \t\t\t\t});\n");
      out.write("            \t\t\t}\n");
      out.write("            \t\t});\n");
      out.write("        \t    }\n");
      out.write("        \t});\n");
      out.write("        }\n");
      out.write("    }];\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
