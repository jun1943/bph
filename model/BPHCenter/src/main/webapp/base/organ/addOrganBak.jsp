<%@ page language="java" pageEncoding="UTF-8"%>

<div id="addOrgan" style="position: absolute;z-index:10000;left:266px;top:87px;display:none;">
	<!-- <div class="line1-mid" id="addDialog">
		<div class=" t1-start fl"></div>
		<div class="t1-end fr"></div>
		<div>
			<a href="#" class="window-close"></a>
		</div>
	</div> -->
	<%-- <div class="fr mt8 mr5">
		 <img src="<%=basePath%>Skin/Default/images/window-right.png">
	</div> --%>
	<div>
		<a href="javascript:void(0)" onclick="addMsgInfo()" class="window-close"></a>
	</div>
	<div class="mid">
		<!----中部---->


		<div id="using" class="fl">
			<!----应用界面---->

			<div class="mt5">
				<div class="fl mt5 mr5">
					<img src="<%=path %>/Skin/Default/images/mark3.png">
				</div>
				<h2>添加机构</h2>
			</div>
			<hr class="hr mt8">
			<div class="mid-form auto mt10">
				<!----表单---->
				<table class="form-table">
					<tr>
						<td>机构名称：</td>
						<td>
							<table class="text-table">
								<tr>
									<td class=" text-left"></td>
									<td><input id="aName" type="text"
										class="form-control w258 text" placeholder="等待输入..."></td>
									<td class="text-right"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>机构编码：</td>
						<td>
							<table class="text-table">
								<tr>
									<td class=" text-left"></td>
									<td><input id="aCode" type="text"
										class="form-control w258 text" placeholder="等待输入..."></td>
									<td class="text-right"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>机构简称：</td>
						<td>
							<table class="text-table">
								<tr>
									<td><img
										src="<%=path %>/Skin/Default/images/text-left.png"></td>
									<td><input id="aShortName" type="text"
										class="form-control w258 text" placeholder="等待输入..."></td>
									<td><img
										src="<%=path %>/Skin/Default/images/text-right.png"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>机构类型：</td>
						<td><select id="aOrgTypeCode" class="form-control w258">
								<option value="">---请选择类型---</option>
								<option value="1">市局</option>
								<option value="2">分局</option>
								<option value="3">市局直属</option>
								<option value="4">分局机关</option>
								<option value="5">派出所</option>
						</select></td>
					</tr>
					<tr>
						<td>上级机构：</td>
						<td>
							<table class="text-table">
								<tr>
									<td class=" text-left"></td>
									<td><input id="aParentId" type="hidden" value="" /> <input
										type="text" id="aParentName" value="" placeholder="单击左侧选择..."
										class="form-control w258 text" readonly></td>
									<td class="text-right"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>机构备注：</td>
						<td><textarea id="aArea" class=" textarea w640 h260 mt12"></textarea>
						</td>
					</tr>
				</table>
				<hr class="hr mt20">
				<div>
					<a href="#" onclick="addOrgan()" class="button-red auto mt40">确认添加</a>
				</div>
			</div>
			<!----表单结束---->
			<hr class="hr mt10">
		</div>

		<div class="line1-mid mt8">
			<div class=" b1-start fl"></div>
			<div class=" b1-end fr"></div>
		</div>
	</div>
</div>