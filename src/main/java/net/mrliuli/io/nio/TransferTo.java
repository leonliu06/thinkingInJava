package net.mrliuli.io.nio;

/**
 * Created by li.liu on 2017/12/12.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 特殊方法TransferTo()和TransferFrom()允许我们将一个通道和另一个通道直接相连
 */
public class TransferTo {

    public static void main(String[] args) throws Exception{
        if(args.length != 2){
            System.out.println("arguments : sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);

        // Or
        // out.transferFrom(in, 0, in.size());
    }
}
