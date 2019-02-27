import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class Entry extends ClassLoader implements Opcodes {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(InnerClass.class.getName());
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new TestClassVisitor(cw);
        cr.accept(cv, Opcodes.ASM5);
        byte[] code = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream("out/InnerClass1.class");
        fos.write(code);
        fos.close();
        Entry loader = new Entry();
        Class clz = loader.defineClass("Entry$InnerClass", code, 0, code.length);
        Object o = clz.newInstance();
        Method method = o.getClass().getMethod("newFunc", String.class);
        method.invoke(o, "nimei");
    }

    static class InnerClass {

        public void newFunc(String str) {
            System.out.println(str);
        }
    }
}
