package tech.tablesaw.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class WriteOptions {

  protected final Destination dest;
  // CS304 Issue link: https://github.com/jtablesaw/tablesaw/issues/750
  protected final boolean autoClose;

  /**
   * Construct WriteOptions CS304 Issue link: https://github.com/jtablesaw/tablesaw/issues/750
   *
   * @param builder WriteOptions.Builder
   */
  protected WriteOptions(Builder builder) {
    this.dest = builder.dest;
    this.autoClose = builder.autoClose;
  }

  public Destination destination() {
    return dest;
  }

  public static class Builder {

    protected Destination dest;
    protected boolean autoClose = false;

    protected Builder(Destination dest) {
      this.dest = dest;
    }

    protected Builder(OutputStream dest) {
      this.dest = new Destination(dest);
    }

    protected Builder(Writer dest) {
      this.dest = new Destination(dest);
    }

    /**
     * Construct WriteOptions.Builder with File CS304 Issue link:
     * https://github.com/jtablesaw/tablesaw/issues/750
     *
     * @param dest Output Destination
     * @throws IOException threw by new Destination(File file)
     */
    protected Builder(File dest) throws IOException {
      this.dest = new Destination(dest);
      this.autoClose = true;
    }
  }
}
