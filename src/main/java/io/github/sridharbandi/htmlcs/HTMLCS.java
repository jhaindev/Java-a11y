/**
 * Copyright (c) 2019 Sridhar Bandi.
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
 */
package io.github.sridharbandi.htmlcs;

import io.github.sridharbandi.util.Statik;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HTMLCS {

    private static Logger LOG = LoggerFactory.getLogger(HTMLCS.class);

    private static HTMLCS instance = null;

    private String htmlcs;

    private HTMLCS(){
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream in = cl.getResourceAsStream(Statik.HTMLCS_PATH);
        try {
            if (in == null) {
                throw new IOException("InputStream failed for: "+Statik.HTMLCS_PATH);
            }
            htmlcs = IOUtils.toString(in, Statik.ENCODING);
        } catch ( IOException e) {
            LOG.error("Failed to read the file HTMLCS.js %s", e.getMessage());
            e.printStackTrace();
        }
    }

    public static HTMLCS getInstance(){
        return (instance == null)? new HTMLCS() : instance;
    }

    public String getHTMLCS(){
        return htmlcs;
    }
}