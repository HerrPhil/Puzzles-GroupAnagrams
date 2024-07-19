# Puzzles-GroupAnagrams

Given a list of strings/words, group the anagrams into a list of lists.

## Lesson Task Description

The input to the problem is a list of string.

For example:

```
[cat, tac, bat, tab]
```

Note cat and tac are anagrams.

Note bat and tab are anagrams.

The desired outcome is to group them.

For example:

```
[[cat, tab], [bat, tab]]
```

Why are cat and tab anagrams?

They both have 1 'c', 1 'a', and 1 't'.

That is, their frequency of letters are identical.

Suppose we have a letter-counting array for cat.

 a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
[1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]

This allows us to make a hash map, where the key will be the frequency,
and the value will be a list of all the matching anagrams.


