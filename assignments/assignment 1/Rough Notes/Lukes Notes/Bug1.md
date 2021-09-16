## CTRL-F fails when target text is behind cursor:

### Reported by:

Luke Linigari luke5011@my.yorku.ca

### Date reported:

9/16/21

### Program (or component) name:

BORG calendar, Memo tab specifically

### Configuration(s):

Laptop
Windows 10
x64-based processor

### Report type:

Design Issue

### Reproducibility:

yes.Changing window size or apearnace does not affect reproducibility

### Severity:

Minor

### Problem summary:

ctrl-f in the memo tab fails if the target text is anywhere behind the cursor

### Problem description:

In the memos tab, if you try and use ctrl-f on the text you just wrote, it will only look for instances of that word after the cursor.
How to reproduce:

1. Load the program
2. Navigate to the memos tab
3. write any string of text, can be a single word or a sentence
4. after finishing writing, dont move the cursor
5. use ctrl-f and search for any char or string you typed
6. you will observe "not Found - End of search..."

You can change the position of the cursor to where ever in the text, it will still only look ahead of it when looking for matches for the target text. Eg: try "this is so|me text" (cursor in middle of "so|me"), ctrl-f "this" wont work.

### wNew or old bug:

New
