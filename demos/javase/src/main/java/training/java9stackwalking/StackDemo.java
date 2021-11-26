package training.java9stackwalking;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StackDemo {

    public static void main(String[] args) {
        new StackDemo().aa();
    }


    public void aa() {
        aaaa();
    }

    private void aaaa() {
        bb();
    }

    private void bb() {
        bbbb();
    }

    private void bbbb() {
//        StackWalker.getInstance()
//                .forEach(frame -> System.out.println("frame: " + frame));

        List<String> names = StackWalker.getInstance()
                .walk(this::collectShortMethodNames);
        System.out.println(names);
    }

    private List<String> collectShortMethodNames(Stream<StackWalker.StackFrame> frames) {
        return frames
                .filter(frame -> frame.getMethodName().length() == 2)
                .map(StackWalker.StackFrame::getMethodName)
                .collect(Collectors.toList());
    }

}
