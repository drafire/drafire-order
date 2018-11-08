package com.drafire;

import com.alibaba.dubbo.container.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //如果停止了服务，则zookeeper 的节点会被删除
        Main.main(args);
    }
}
