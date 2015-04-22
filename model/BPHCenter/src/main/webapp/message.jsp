<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 提示框 -->
 <div id="box" style="position: absolute;z-index:10000;left:630px;top:250px;display:none;">
    <div class="line1-mid">
      <div class=" t1-start fl"></div>
      <div class="t1-end fr"></div>
    </div>
    <div class="fr mt8 mr5"><img src="<%=basePath%>Skin/Default/images/window-right.png"></div>
    <div class="information-body mt8">
       <div class="information-top">
        <div><h1>提示</h1></div>
      </div>
      <div class="information-mid">
        <table class="form-table">
          <tr>
            <td class="information-logo"></td>
            <td class="pl30"><p id="message"></p></td>
          </tr>
        </table>
        <hr class="hr mt40">
        <div class="mt12"><a href="javascript:void(0)" onclick="clolseMsgInfo()" class="button-red1 auto">确认</a></div>
      </div>
      <div class="information-bottom"></div>
    </div>
    <div class="line1-mid mt8">
      <div class=" b1-start fl"></div>
      <div class=" b1-end fr"></div>
    </div>
 </div>