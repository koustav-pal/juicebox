/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2011-2016 Broad Institute, Aiden Lab
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
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package juicebox.tools.clt.old;

import jargs.gnu.CmdLineParser;
import juicebox.tools.clt.JuiceboxCLT;
import juicebox.tools.utils.original.HiCDBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class SQLDatabase extends JuiceboxCLT {

    private String[] dbArgs;

    public SQLDatabase() {
        super("db <frag|annot|update> [items]");
    }

    @Override
    public void readArguments(String[] args, CmdLineParser parser) {
        //setUsage("juicebox db <frag|annot|update> [items]");
        dbArgs = new String[args.length - 1];
        System.arraycopy(args, 1, dbArgs, 0, args.length - 1);
    }

    @Override
    public void run() {

        try {
            HiCDBUtils.main(dbArgs);
        } catch (SQLException e) {
            System.err.println("Sql exception: " + e.getMessage());
            e.printStackTrace();
            System.exit(61);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
