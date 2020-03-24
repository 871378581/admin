package com.segama.ege.admin.constants;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum IconEnum {
    A(1,"&#xe68f;","实心"),
    B(2,"&#xe68c;","空心"),
    C(3,"&#xe748;","亮度/晴"),
    D(4,"&#xe68d;","时间/历史"),
    E(5,"&#xe627;","礼物/活动"),
    F(6,"&#xe626;","客服"),
    G(7,"&#xe66d;","打印"),
    H(8,"&#xe6c9;","半星"),
    I(9,"&#xe67a;","星星-实心"),
    J(10,"&#xe66f;","用户名"),
    K(11,"&#xe68e;","主页"),
    L(12,"&#xe66e;","便签"),
    M(13,"&#xe702;","提示说明"),
    N(14,"&#xe66c;","旗帜"),
    O(15,"&#xe716;","设置-空心"),
    P(16,"&#xe665;","控制台"),
    Q(17,"&#xe653;","应用"),
    R(18,"&#xe65f;","菜单-水平"),
    S(19,"&#xe671;","菜单-垂直"),
    T(20,"&#xe715;","位置-地图"),
    U(21,"&#xe705;","办公-阅读"),
    V(22,"&#xe857;","组件"),
    W(23,"&#xe770;","用户"),
    X(24,"&#xe670;","发现-实心"),
    Y(25,"&#xe631;","工具"),
    Z(26,"&#xe623;","右三角"),
    A1(27,"&#xe620;","设置-小型"),
    B1(28,"&#xe614;","设置-实心"),
    C1(29,"&#xe658;","收藏-实心"),
    D1(30,"&#xe606;","客服"),
    ;

    public static List<Map<String,String>> getAllIcon(){
        List<Map<String,String>> list = Lists.newArrayList();
        IconEnum[] values = IconEnum.values();
        for (IconEnum value : values) {
            Map<String,String> map = new HashMap<>();
            map.put("label",value.name);
            map.put("value",value.codeId.toString());
            list.add(map);
        }
        return list;
    }

    public static String  getCode(Integer codeId){
        IconEnum[] values = IconEnum.values();
        for (IconEnum value : values) {
            if(value.codeId.equals(codeId)){
                return value.code;
            }
        }
        return "&#xe716;";
    }



    private Integer codeId;
    private String code;
    private String name;
    IconEnum(Integer codeId,String code,String name){
        this.codeId=codeId;
        this.code=code;
        this.name=name;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
