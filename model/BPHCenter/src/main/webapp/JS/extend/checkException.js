function checkForms(obj){
    var iu, iuu, regArray=new Array("◎","■","●","№","↑","→","↓","?",+
    "!","@","#","$","%","^","&","*","(",")","_","-","+","=","|","[","]","？","~","`",+
    "<",">","‰","←","¤","§","＃","＆","＆","＼","≡","≠",+
    "≈","∈","∪","∏","∑","∧","∨","⊥","‖","∠","⊙","≌","√","∝","∞","∮",+
    "∫","≯","≮","＞","≥","≤","≠","±","＋","÷","×","/","Ⅱ","Ⅰ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅹ","Ⅻ","一","二",+
    "╄","╅","╇","┻","┻","┇","┭","┷","┦","┣","┝","┤","┷","┷","┹","╉","╇","【","】",+
    "三","四","五","六","七","八","九","十","①","②","③","④","⑤","⑥","⑦","⑧","⑨","⑩","┌","├","┬","┼","┍","┕","┗","┏","┅","—",+
    "〖","〗","←","〓","☆","§","□","‰","◇","＾","＠","△","▲","＃","℃","※",".","≈","￠");
    iuu=regArray.length;
    for(iu=1;iu<=iuu;iu++){
    	if ($.trim($(obj).val()).indexOf(regArray[iu])>-1){
    		$("body").tyWindow({title:"警告",ok:true,content:"输入内容不可以包含：" + regArray[iu]});
    		return false;
    	}
    }
    return true;
}