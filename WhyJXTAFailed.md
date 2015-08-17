# Personal Opinions on Why JXTA Failed #

I knew JXTA a log time a long ago and took a close at it recently because I wanted to use it to prototype a data pushing/streaming framework. Apparently, JXTA does not satisfy my need and it seems dead when I looked at its project website and its community. This brings up one interesting question: "why JXTA failed?".

After thinking of it for some time, I have some personal opinions on its failure.

## Wrong Target ##

If you look at JXTA protocol stack, you will see it includes service down to communication layers. It seems include everything but cannot actually address any of them. First, it is hardly a peep to peer communication building block, because it does not address the peer group automated management problem or lack of protocols to form practical peer to peer groups. For example, we may need hierarchical peer groups with leader nodes, routing protocols, UDP protocols.

On the contrary, JXTA looks more like a service oriented framework, but we have already had web services, ESB, and other SOA techniques. Seems there is no real requirements for peer to peer based SOA unless cloud computing will be the future and we have unknown/dynamic services. But the underly protocols in JXTA do not really handle the dynamic nature of the group very well and this leads to question of whether it is really suitable for a dynamic SOA architecture.

As a result, JXTA can hardly find its place in applications until tomorrow will be a different world. That is to say, JXTA is in an embarrassing situation now to find a right target for itself.

## Too Much Flavor for J2EE ##

Seems JXTA is designed by people with heavy J2EE experience instead of networking background.

First, XML is used for all protocol messages even between inner layers. XML might make sense for communication command/handshake only at the layers that will talk to other nodes in the network, but not for all layers and all messages. XML is really verbose for actual communication such as data transmission.

Second, why on the earth JXTA needs the service layer? In my opinion, it would be more appropriate to only focus on the peer to peer communication part and do not care about what data or application it needs to serve. One of the most important design principles is separation of concerns. Unfortunately, JXTA tries to address everything, but some times "all" means "none".

## Lack of protocols for peer group management ##

Right now, JXTA node just tries to join one group and there is no hierarchical sub-groups. For practical applications, most likely you need to form some hierarchical sub-groups with leaders elected for each sub-group. The flat structure, i.e., all peers in one group cannot really scale well and not really appropriate for applications such as application level multicast or data pushing.

We also need routing protocols, congest control, acknowledgment aggregation, and UDP support features for peer to peer networks. Obviously, JXTA is not designed by people from networking background and the lack of the protocols makes it hardly a building block for peer to peer communications.