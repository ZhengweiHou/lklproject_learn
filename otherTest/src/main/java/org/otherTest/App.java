package org.otherTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StringBuilder help = new StringBuilder();
		help.append("帮助：").append("\n")
		.append("1.配置文件").append("\n")
		.append("\t").append("aps_move.env").append("\n")
		.append("2.执行程序-执行代码要按顺序执行").append("\n")
		.append("\t").append("sh run.sh 【代码】").append("\n")
		.append("\t").append("代码及其描述：").append("\n")
		.append("\t").append("0").append("\t").append("处理更新订单表JsonInfo字段").append("\n")
		.append("\t").append("1").append("\t").append("生成无订单申请的订单及其JsonInfo字段").append("\n")
		.append("\t").append("2").append("\t").append("通过订单启动在途申请").append("\n");
        System.out.println( help.toString() );
    }
}
