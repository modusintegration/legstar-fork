legstar-fork
============

Forked legstar project

We mainly use the "core" packages, so usually it's enough to do:

cd legstar-core

mvn install


and then update your poms to use the current version.

We forked at 1.5.11-SNAPSHOT:
- Patch the nested REDEFINES sections
- Ignore some tests that are hardcoded to pass only in CEST timezone


