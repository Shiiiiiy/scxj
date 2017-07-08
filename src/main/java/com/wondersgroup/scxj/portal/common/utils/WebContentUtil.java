package com.wondersgroup.scxj.portal.common.utils;

import java.util.List;

public class WebContentUtil {

	//处理内容里面的图片的url连接
	public static String analyseImgSrc(String content, String docChannel){
		List picSrcList = RegPatternUtil.findImgSrcOfHtml(content);
		String picPreSrl = "";
		for (int i = 0; i < picSrcList.size(); i++) {
			picPreSrl = "http://www.shjcy.gov.cn/";
			String picSrc = picSrcList.get(i).toString();
			
			if(docChannel != null){
				if("62".equals(docChannel)){
					picPreSrl += "jcxw";
				}else if("61".equals(docChannel)){
					picPreSrl += "tpbd";
				} else if("60".equals(docChannel)){
					picPreSrl += "wwgg";
				}else if("160".equals(docChannel)){
					picPreSrl += "fzjw";
				}
			}
			if(StringUtils.startsWith(picSrc, "./")){
				picSrc = StringUtils.substring(picSrc, 2);
			} else {
				
			}
			picPreSrl += "/" + picSrc.substring(2, 8)+"/"+picSrc;
			content = content.replace(picSrcList.get(i).toString(), picPreSrl);
			
		}
		return content;
	}

	public static String clearWordFormat(String content) {
		//把<P></P>转换成</div></div>保留样式
		//content = content.replaceAll("(<P)([^>]*>.*?)(<\\/P>)", "<div$2</div>");
		//把<P></P>转换成</div></div>并删除样式
		content = content.replaceAll("(<P)([^>]*)(>.*?)(<\\/P>)", "<p$3</p>");
		//删除不需要的标签
		content = content.replaceAll("<[/]?(font|FONT|span|SPAN|xml|XML|del|DEL|ins|INS|meta|META|[ovwxpOVWXP]:\\w+)[^>]*?>", "");
		//删除不需要的属性
		//content = content.replaceAll("<([^>]*)(?:lang|LANG|class|CLASS|style|STYLE|size|SIZE|face|FACE|[ovwxpOVWXP]:\\w+)=(?:'[^']*'|\"\"[^\"\"]*\"\"|[^>]+)([^>]*)>", "<$1$2>");
		//删除<STYLE TYPE="text/css"></STYLE>及之间的内容
		int styleBegin = content.indexOf("<STYLE");
		int styleEnd = content.indexOf("</STYLE>") + 8;
		if(styleBegin < 0 || styleEnd < 8){
			 styleBegin = content.indexOf("<style");
			 styleEnd = content.indexOf("</style>") + 8;
		}
		if(styleBegin >= 0 || styleEnd >= 8){
			String style = content.substring(styleBegin, styleEnd);
			content = content.replace(style, "");
		}
		
		return content;
	}
	

}
