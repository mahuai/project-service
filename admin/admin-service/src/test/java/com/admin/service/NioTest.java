package com.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

/**
 * @author ms
 * @Description: class description
 * @Package com.admin.service
 * @date: Created in 2018/8/27  14:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminServiceApplication.class)
public class NioTest {

   /* @Test
    public  void client() {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1", 9898));
            ByteBuffer buf = ByteBuffer.allocate(1024);
            channel.configureBlocking(false);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String msg = scanner.nextLine();
                buf.put((System.currentTimeMillis() + ": " + msg).getBytes());
                buf.flip();
                channel.write(buf);
                buf.clear();
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public  void service() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9898));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        //10. 可读事件处理
                        SocketChannel channel = (SocketChannel) key.channel();
                        readMsg(channel);
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readMsg(SocketChannel channel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int len = 0;
        while ((len = channel.read(buf)) > 0) {
            buf.flip();
            byte[] bytes = new byte[1024];
            buf.get(bytes, 0, len);
            System.out.println(new String(bytes, 0, len));
        }
    }


    @Test
    public void nioTest(){
        client();
        service();
    }*/

    @Test
    public void beanTest() {

    }
}
