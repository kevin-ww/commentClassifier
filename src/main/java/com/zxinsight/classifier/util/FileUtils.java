package com.zxinsight.classifier.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.zxinsight.classifier.util.ShellUtils.CommandResult;

public class FileUtils {

  public final static boolean RUN_SHELL_AS_NO_ROOT = true;

  public static int getLineCount(File file) throws IOException {

    final String shellCommand = "wc -l " + file.getAbsolutePath();

    System.out.println(shellCommand);

    if (!file.isFile()) {
      throw new IOException("not a file");
    }

    CommandResult result = ShellUtils.execCommand(shellCommand, false);

    System.out.println(result);

    return 0;
  }

  public static void main(String[] args) throws IOException,
      InterruptedException {
    String file = "/cygdrive/E/wrkspace/text-classification-v2/ref/test.csv";

    File f = new File(file);

    getLineCount(f);
    // Collection<File> files = FileUtils.split(new File(file));
    // System.out.println(files);

    // CommandResult result = ShellUtils.execCommand("ls -l", false);
    // System.out.println(result);
  }

  public static void makeTmpWorkingDir(File file) {

  }

  public static Collection<File> split(File file) throws IOException,
      InterruptedException {
    return null;
  }

}
