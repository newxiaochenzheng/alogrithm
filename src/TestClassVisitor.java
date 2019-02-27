import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class TestClassVisitor extends ClassVisitor {

    public TestClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if (cv != null) {
            cv.visit(version, access, name, signature, superName, interfaces);
        }
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String signature, String superName, String[] interfaces) {
        if ("newFunc".equals(name)) {
            MethodVisitor mv = cv.visitMethod(access, name, signature, superName, interfaces);
            return new TestMethodVisitor(mv);
        }
        System.out.println();
        if (cv != null) {
            cv.visitMethod(access, name, signature, superName, interfaces);
        }
        return null;
    }
}