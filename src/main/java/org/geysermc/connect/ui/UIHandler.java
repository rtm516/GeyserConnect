/*
 * Copyright (c) 2019-2020 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/GeyserConnect
 */

package org.geysermc.connect.ui;

import org.geysermc.common.window.CustomFormBuilder;
import org.geysermc.common.window.CustomFormWindow;
import org.geysermc.common.window.FormWindow;
import org.geysermc.common.window.component.LabelComponent;
import org.geysermc.common.window.response.CustomFormResponse;
import org.geysermc.connect.utils.Player;
import org.geysermc.connector.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class UIHandler {

    /**
     * Create a message form
     *
     * @return A {@link CustomFormWindow} object
     */
    public static FormWindow getMessageWindow() {
        String message = "Failed to load message.txt";
        try {
            File messageFile = FileUtils.fileOrCopiedFromResource(new File("message.txt"), "message.txt", (x) -> x);
            message = new String(FileUtils.readAllBytes(messageFile));
        } catch (IOException e) { }

        CustomFormWindow window = new CustomFormBuilder("Notice")
                .addComponent(new LabelComponent(message))
                .build();
        return window;
    }

    /**
     * Handle the server list response
     *
     * @param player The player that submitted the response
     * @param data The form response data
     */
    public static void handleMessageWindowResponse(Player player, CustomFormResponse data) {
        player.getSession().disconnect("disconnectionScreen.disconnected");
    }
}
