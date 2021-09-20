# Task 1

# Bug Report 1

## Bug Report Title:

Find Function (CTRL-F) fails when target text is behind cursor

### Reported by:

Luke Linigari luke5011@my.yorku.ca

### Date reported:

9-16-21

### Program (or component) name:

BORG calendar - Memo tab

### Configuration(s):

Windows 10
x64-based processor.

### Report type:

Design Issue.

### Reproducibility:

Yes, can be reproduced. Changing window size or appearance does not affect reproducibility.

### Severity:

Minor Issue.

### Problem summary:

The find function (CTRL-F) in memo tab only searches past the cursor.

### Problem description:

In the memos tab, if you try and use the find function (CTRL-F) on the text you just wrote, it will only look for instances of that word after the cursor.

How to reproduce:

1. Load the program
2. Navigate to the memos tab
3. Write any string of text, can be a single word or a sentence
4. Ensure your cursor is placed after written text
5. Use the find function (CTRL-F) and search for any char or string you typed
6. You will observe a "not Found - End of search..." popup window apears

- You can change the position of the cursor to where ever in the text, it will still only look ahead of it when looking for matches for the target text. Eg: try "this is so|me text" (cursor in middle of "so|me"), searching for "this" wont work.
- After you get the error message, the cursor moves itself to the beginning of the file from where you last placed it.

### New or old bug:

New Bug.
