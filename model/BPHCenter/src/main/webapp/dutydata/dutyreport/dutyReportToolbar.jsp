<%@ page language="java" pageEncoding="UTF-8"%>


<table border=0>
		<tr>
			<td >时间范围:</td>
			<td style="width: 213px; "><input id="dteBeginDate"  /></td>
			<td>&nbsp;</td>
			<td><input id="spnBeginTime"  /></td>
			<td><input id="spnEndTime"    /></td>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td >任务属性:</td>
			<td><input id="dutyProperty" /></td>
			<td>&nbsp;</td>
			<td >勤务类型 :</td>
			<td><input id="cmbdutytype"  ></td>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="MySearchTDTitle">人员类别 :</td>
			<td><input id="cmbpoliceType"  /></td>
			<td>&nbsp;</td>
			<td class="MySearchTDTitle">衣着:</td>
			<td>
				<input id="ckAttireType1" type="checkbox"  value="0">着装　　　
				<input id="ckAttireType2" type="checkbox"  value="1">便衣
			</td>
			<td class="MySearchTDTitle">武装:　</td>
			<td>
				<input id="ckArmamentType1" type="checkbox" value="0">非武装　　
				<input id="ckArmamentType2" type="checkbox" value="1">武装　　
			</td>
			<td class="MySearchTDTitle"> <button id="btnDutyReportSearch" class="fr ty-btn-search" onclick="reportManage.search()"/> 　</td>
		</tr>
	</table>
