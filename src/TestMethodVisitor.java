import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import static jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC;

public class TestMethodVisitor extends MethodVisitor {
    public TestMethodVisitor(MethodVisitor methodVisitor) {
        super(Opcodes.ASM5, methodVisitor);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("===start1======");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/System", "println", "(Ljava/lang/String;)V", false);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("===end======");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/System", "println", "(Ljava/lang/String;)V", false);
        }
        super.visitInsn(opcode);
    }
}
