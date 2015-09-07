/**
 * DelegateMegaTreeProcessor.java
 * Delegation pattern for MegaTreeProcessor
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

class DelegateMegaTreeProcessor extends MegaTreeProcessor {
    MegaApiJava megaApi;
    MegaTreeProcessorInterface listener;

    DelegateMegaTreeProcessor(MegaApiJava megaApi, MegaTreeProcessorInterface listener) {
        this.megaApi = megaApi;
        this.listener = listener;
    }

    public boolean processMegaNode(MegaNode node) {
        if (listener != null)
            return listener.processMegaNode(megaApi, node);
        return false;
    }
}
