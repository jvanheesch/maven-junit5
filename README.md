# Demo: surefire and failsafe
Remarks:
* surefire has 1 goal (test), while failsafe has 2 goals (integration-test, verify)
* surefire:test goal is bound to default lifecycle, while failsafe goals are not
* junit5 tests may not run when surefire/failsafe version is too low
