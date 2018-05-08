<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>网页特效 常用的二级联动表单 站长特效网</title>
</head>
<body>
<a href="http://www.zzjs.net/">站长特效网</a>,站长必备的高质量网页特效和广告代码。zzjs.net，站长js特效。<hr>
<!--欢迎来到站长特效网，我们网站收集大量高质量js特效，提供许多广告代码下载，网址：www.zzjs.net，zzjs@msn.com,用.net打造靓站-->
<form id="submit_form_zzjs" name="submit_form_zzjs" method="post" action="">
网站分类
<script language="javascript">
<!--
var subcat=new Array();
var biglist=new Array('电子数码 ','服装','图书、电子书刊','家居、家具、厨具');

subcat[0]=new Array('0',' 电脑、办公',' 电脑、办公')
subcat[1]=new Array('0','家用电器','家用电器')
subcat[2]=new Array('0','手机数码 ','手机数码')
subcat[3]=new Array('1','音乐mp3','音乐mp3')
subcat[4]=new Array('3','聊天QQ','聊天QQ')
subcat[5]=new Array('2','论坛社区','论坛社区')
function changeselect_zzjs_net(locationid)
{
for(j=0;j<biglist.length;j++)
if(biglist[j]==locationid){
locationid=j;
}
document.submit_form_zzjs.smallclass_zzjs_net.length=0;//初始化下拉列表，清空下拉数据
document.submit_form_zzjs.smallclass_zzjs_net.options[0]=new Option('所有小类','所有小类');//给第一个值
for(i=0;i<subcat.length;i++)
{
if(subcat[i][0]==locationid)
{
document.submit_form_zzjs.smallclass_zzjs_net.options[document.submit_form_zzjs.smallclass_zzjs_net.length]=new Option(subcat[i][1],subcat[i][2]);}//建立option
}
}
//-->
</script>
<select name="bigclass" onchange="changeselect_zzjs_net(this.value)">

 <option value="-- 请选择 --" selected>-- 请选择 --</option>
       <option value="服装" >服装 </option>
      <option value="图书、电子书刊 " >图书、电子书刊 </option>
      <option value="电子数码" > 电子数码 </option>
      <option value=" 家居、家具、厨具 " > 家居、家具、厨具 </option>
</select>
<select name="smallclass_zzjs_net">
<option value="所有小类" selected>所有小类</OPTION>
</select>
</form>
</body>
</html>
 