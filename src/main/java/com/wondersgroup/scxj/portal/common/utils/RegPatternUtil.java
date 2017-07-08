package com.wondersgroup.scxj.portal.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegPatternUtil {
	
	/**
	 * 在html中找到指定标签的元素
	 * @param html
	 * @param tag
	 * @return
	 */
	public static List findTagsOfHtml(String html, String tag){
		if(html == null) html = "";
		html = html.toLowerCase();
		List tagsArr = new ArrayList();
		String tagExp = "<\\s*"+tag+"\\s+([^>]*)\\s*>";
		Pattern pattern = Pattern.compile(tagExp);
		Matcher matcher = pattern.matcher(html);
		boolean result = matcher.find();
		while(result){
			tagsArr.add(matcher.group());
			result = matcher.find();
		}
		return tagsArr;
	}
	
	/**
	 * 在html中找到指定标签的属性
	 * @param html
	 * @param tag
	 * @return
	 */
	public static List findTagsAttrOfHtml(String html, String tag, String attr){
		if(html == null) html = "";
		html = html.toLowerCase();
		List attrArr = new ArrayList();
		String tagExp = "<"+tag+"[^<>]*?\\s"+attr+"=['\"]?(.*?)['\"]?\\s.*?>";
		Pattern pattern = Pattern.compile(tagExp);
		Matcher matcher = pattern.matcher(html);
		boolean result = matcher.find();
		while(result){
			attrArr.add(matcher.group(1));
			result = matcher.find();
		}
		return attrArr;
	}
	
	/**
	 * 在html中找到所有标签的某个属性
	 * @param html
	 * @param tag
	 * @return
	 */
	public static List findAttrOfHtml(String html, String attr){
		if(html == null) html = "";
		html = html.toLowerCase();
		List attrArr = new ArrayList();
		String tagExp = "<[^<>]*?\\s"+attr+"=['\"]?(.*?)['\"]>";
		Pattern pattern = Pattern.compile(tagExp);
		Matcher matcher = pattern.matcher(html);
		boolean result = matcher.find();
		while(result){
			attrArr.add(matcher.group(1));
			result = matcher.find();
		}
		return attrArr;
	}
	
	
	/**
	 * 在html中找到指定标签的属性
	 * @param html
	 * @param tag
	 * @return
	 */
	public static List findImgSrcOfHtml(String html){
		return RegPatternUtil.findTagsAttrOfHtml(html, "img", "src");
	}
	
	public static List findImgTagsOfHtml(String html){
		return RegPatternUtil.findTagsOfHtml(html, "img");
	}
	
	
	/**
	 * 在html中找到所有标签的某个属性
	 * @param html
	 * @param tag
	 * @return
	 */
	public static List findClassOfHtml(String html, String attr){
		if(html == null) html = "";
		html = html.toLowerCase();
		List attrArr = new ArrayList();
		String tagExp = "(<[^>]+) class=[^ |^>]*([^>]*>)";
		Pattern pattern = Pattern.compile(tagExp);
		Matcher matcher = pattern.matcher(html);
		boolean result = matcher.find();
		while(result){
			attrArr.add(matcher.group(1));
			result = matcher.find();
		}
		return attrArr;
	}
	public static void main(String[] args){
		System.out.println(RegPatternUtil.findClassOfHtml("<span class=aaaa font=\"font-size: 15px;\">","class"));
	}
}
