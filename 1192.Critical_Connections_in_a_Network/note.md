* [Reference](https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/No-TarjanDFS-detailed-explanation-O(orEor)-solution-(I-like-this-question))
* Points of implementation
  * Not visit parent again, nut need to update returned min rank according to all neighbors, visited or not.
  * Update min rank when:
    1. There is a non-parent neighbor that has smaller rank than current rank.
    2. A next point returns a smaller rank than current.
