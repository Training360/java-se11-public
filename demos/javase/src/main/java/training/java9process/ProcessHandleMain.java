package training.java9process;

import java.util.concurrent.CountDownLatch;

public class ProcessHandleMain {

    public static void main(String[] args) {
        ProcessHandle
                .allProcesses()
                .map(ProcessHandle::info)
                .filter(info -> info.command().isPresent() && info.command().get().contains("notepad.exe"))
                .forEach(System.out::println);

//        ProcessHandle
//                .allProcesses()
//                .filter(handle -> handle.info().command().isPresent() && handle.info().command().get().contains("notepad.exe"))
//                .forEach(p -> p.destroy());

        CountDownLatch latch = new CountDownLatch(1);
               ProcessHandle
                    .allProcesses()
                    .filter(handle -> handle.info().command().isPresent() && handle.info().command().get().contains("notepad.exe"))
                       .forEach(handle -> handle.onExit().thenApply(
                               (ph) -> {
                                   System.out.println("Notepad exited");
                                   latch.countDown();
                                   return ph;
                               }
                       ));

               try {
                   latch.await();
               }catch (InterruptedException ie) {
                   throw new IllegalStateException("Interrupted", ie);
               }
    }
}
