<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${APP_PATH }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH }/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH }/css/theme.css">
	<style>
#footer {
    padding: 15px 0;
    background: #fff;
    border-top: 1px solid #ddd;
    text-align: center;
}
#topcontrol {
  color: #fff;
  z-index: 99;
  width: 30px;
  height: 30px;
  font-size: 20px;
  background: #222;
  position: relative;
  right: 14px !important;
  bottom: 11px !important;
  border-radius: 3px !important;
}

#topcontrol:after {
  /*top: -2px;*/
  left: 8.5px;
  content: "\f106";
  position: absolute;
  text-align: center;
  font-family: FontAwesome;
}

#topcontrol:hover {
    color: #fff;
    background: #18ba9b;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

.label-type, .label-status, .label-order {
    background-color: #fff;
    color: #f60;
    padding : 5px;
    border: 1px #f60 solid;
}
#typeList  :not(:first-child) {
    margin-top:20px;
}
.label-txt {
    margin:10px 10px;
    border:1px solid #ddd;
    padding : 4px;
    font-size:14px;
}
.panel {
    border-radius:0;
}

.progress-bar-default {
    background-color: #ddd;
}
	</style>
  </head>
  <body>
 <div class="navbar-wrapper">
      <%@include file="/WEB-INF/jsp/common/membertop.jsp"%>
 </div>

    <div class="container theme-showcase" role="main">

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a rel="nofollow" href="index.html"><i class="glyphicon glyphicon-home"></i> 众筹首页</a>
                                </li>
                                <li >
                                    <a rel="nofollow" href="projects.html"><i class="glyphicon glyphicon-th-large"></i> 项目总览</a>
                                </li>
                                <li class="active">
                                    <a rel="nofollow" href="javascript:;"><i class="glyphicon glyphicon-edit"></i> 发起项目</a>
                                </li>
                                <li>
                                    <a rel="nofollow" href="minecrowdfunding.html"><i class="glyphicon glyphicon-user"></i> 我的众筹</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        
        
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="panel panel-default" >
                        <div class="panel-heading" style="text-align:center;">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-3 column">
                                        <div class="progress" style="height:50px;border-radius:0;    position: absolute;width: 75%;right:49px;">
                                          <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">1. 项目及发起人信息</div>
                                          </div>
                                        </div>
                                        <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(92, 184, 92, 1);
                                             border-top-color: rgba(92, 184, 92, 0);
                                             border-bottom-color: rgba(92, 184, 92, 0);
                                             border-right-color: rgba(92, 184, 92, 0);
                                        ">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress" style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                          <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">2. 回报设置</div>
                                          </div>
                                        </div>
                                        <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress" style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                          <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">3. 确认信息</div>
                                          </div>
                                        </div>
                                        <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress" style="height:50px;border-radius:0;">
                                          <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">4. 完成</div>
                                          </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
<div class="container-fluid">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
				<b>
					项目及发起人信息
				</b>
			</blockquote>
		</div>
		<div class="col-md-12 column">
			<div class="page-header" style="    border-bottom-style: dashed;">
				<h3>
					项目信息
				</h3>
			</div>
            <form id="regProject" class="form-horizontal" method="post" enctype="multipart/form-data">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">分类信息</label>
                <div class="col-sm-10">
                     <label class="radio-inline">
                      <input type="radio" name="type" id="inlineRadio1" value="0"> 科技
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="type" id="inlineRadio2" value="1"> 设计
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="type" id="inlineRadio3" value="2"> 公益
                    </label>
                   <!--  <label class="radio-inline">
                      <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 农业
                    </label> -->
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目名称</label>
                <div class="col-sm-10">
                  <input type="text" name="name" class="form-control" >
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">一句话简介</label>
                <div class="col-sm-10">
                  <textarea class="form-control" name="remark" rows="5"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">筹资金额（元）</label>
                <div class="col-sm-10">
                  <input type="text" name="money" class="form-control" style="width:100px;" >
                  <label class="control-label">筹资金额不能低于100元,不能高于1000000000元</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">筹资天数（天）</label>
                <div class="col-sm-10">
                  <input type="text" name="day" class="form-control" style="width:100px;" >
                  <label class="control-label">一般10-90天，建议30天</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目头图</label>
                <div class="col-sm-10">
                  <input type="file" name="headimg" class="form-control" >
                  <label class="control-label">图片上无文字,支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：740*457px</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目详情</label>
                <div class="col-sm-10">
                  <input type="file" name="detailimg" class="form-control" >
                  <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：宽740px</label>
                </div>
              </div>
            </form>
		</div>
	</div>
</div>
                        </div>
                        <div class="panel-footer" style="text-align:center;">
                            <button id="nextBtn" type="button" class="btn  btn-warning btn-lg" <%-- onclick="window.location.href='${APP_PATH }/project/start-step-2.htm'" --%>>下一步</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <div class="container" style="margin-top:20px;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div id="footer">
                        <div class="footerNav">
                             <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow" href="http://www.layoutit.cn">服务条款</a> | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow" href="http://www.layoutit.cn">网站地图</a> | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                        </div>
                        <div class="copyRight">
                            Copyright ?2017-2017layoutit.cn 版权所有
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
      
    </div> <!-- /container -->
    <script src="${APP_PATH }/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/script/docs.min.js"></script>
    <script src="${APP_PATH }/script/back-to-top.js"></script>
    <script src="${APP_PATH }/jquery/jquery-form/jquery-form.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/jquery/layer/layer.js"></script>
	<script>
	$('#myTab a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	});
	$("#nextBtn").click(function(){
    	var loadingIndex = -1 ;
    	var options = {
   			url:"${APP_PATH}/project/doRegProject.do",
				beforeSubmit : function(){
					loadingIndex = layer.msg('数据正在保存中', {icon: 6});
       			return true ; //必须返回true,否则,请求终止.
				},
				success : function(result){
       			layer.close(loadingIndex);
       			if(result.success){
       				layer.msg("数据保存成功", {time:1000, icon:6});
       				window.location.href="${APP_PATH}/project/start-step-2.htm";
       			}else{
       				layer.msg("数据保存失败", {time:1000, icon:5, shift:6});
       			}	
       		}	
   		};
   		
   		$("#regProject").ajaxSubmit(options); //异步提交
   		return ; 
    });
	</script>
  </body>
</html>