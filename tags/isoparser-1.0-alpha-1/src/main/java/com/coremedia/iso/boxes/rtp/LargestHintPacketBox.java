package com.coremedia.iso.boxes.rtp;

import com.coremedia.iso.BoxFactory;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoInputStream;
import com.coremedia.iso.IsoOutputStream;
import com.coremedia.iso.boxes.Box;

import java.io.IOException;

/**
 * The largest packet, in bytes; includes 12-byte RTP header.
 */
public class LargestHintPacketBox extends Box {
  public static final String TYPE = "pmax";

  private long maxSize;

  public LargestHintPacketBox() {
    super(IsoFile.fourCCtoBytes(TYPE));
  }

  protected long getContentSize() {
    return 4;
  }

  public void parse(IsoInputStream in, long size, BoxFactory boxFactory, Box lastMovieFragmentBox) throws IOException {
    this.maxSize = in.readUInt32();
  }

  public String getDisplayName() {
    return "Largest Hint Packet";
  }

  protected void getContent(IsoOutputStream os) throws IOException {
    os.writeUInt32(maxSize);
  }

  public long getmaxSize() {
    return maxSize;
  }

  public void setMaxSize(long maxSize) {
    this.maxSize = maxSize;
  }
}
