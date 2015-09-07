/**
 * DelegateOutputMegaTransferListener.java
 * Class that extends DelegateMegaTransferListener
 * <p/>
 * (c) 2013-2014 by Mega Limited, Auckland, New Zealand
 * <p/>
 * This file is part of the MEGA SDK - Client Access Engine.
 * <p/>
 * Applications using the MEGA API must present a valid application key
 * and comply with the the rules set forth in the Terms of Service.
 * <p/>
 * The MEGA SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * @copyright Simplified (2-clause) BSD License.
 * <p/>
 * You should have received a copy of the license along with this
 * program.
 */
package nz.mega.sdk;

import java.io.IOException;
import java.io.OutputStream;

public class DelegateOutputMegaTransferListener extends DelegateMegaTransferListener {
    OutputStream outputStream;

    public DelegateOutputMegaTransferListener(MegaApiJava megaApi, OutputStream outputStream, MegaTransferListenerInterface listener,
                                              boolean singleListener) {
        super(megaApi, listener, singleListener);
        this.outputStream = outputStream;
    }

    public boolean onTransferData(MegaApi api, MegaTransfer transfer, byte[] buffer) {
        if (outputStream != null) {
            try {
                outputStream.write(buffer);
                return true;
            } catch (IOException e) {
            }
        }
        return false;
    }
}
