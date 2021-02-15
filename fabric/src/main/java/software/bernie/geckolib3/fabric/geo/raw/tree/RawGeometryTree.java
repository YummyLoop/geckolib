package software.bernie.geckolib3.fabric.geo.raw.tree;

import software.bernie.geckolib3.geo.raw.pojo.Bone;
import software.bernie.geckolib3.geo.raw.pojo.MinecraftGeometry;
import software.bernie.geckolib3.geo.raw.pojo.ModelProperties;
import software.bernie.geckolib3.geo.raw.pojo.RawGeoModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RawGeometryTree {
	public HashMap<String, software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup> topLevelBones = new HashMap<>();
	public ModelProperties properties;

	public static RawGeometryTree parseHierarchy(RawGeoModel model) {

		RawGeometryTree hierarchy = new RawGeometryTree();
		MinecraftGeometry geometry = model.getMinecraftGeometry()[0];
		hierarchy.properties = geometry.getProperties();
		List<Bone> bones = new ArrayList<>(Arrays.asList(geometry.getBones()));

		int index = bones.size() - 1;
		while (true) {
			Bone bone = bones.get(index);
			if (!hasParent(bone)) {
				hierarchy.topLevelBones.put(bone.getName(), new software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup(bone));
				bones.remove(bone);
			} else {
				software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup groupFromHierarchy = getGroupFromHierarchy(hierarchy, bone.getParent());
				if (groupFromHierarchy != null) {
					groupFromHierarchy.children.put(bone.getName(), new software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup(bone));
					bones.remove(bone);
				}
			}

			if (index == 0) {
				index = bones.size() - 1;
				if (index == -1) {
					break;
				}
			} else {
				index--;
			}
		}
		return hierarchy;
	}

	public static boolean hasParent(Bone bone) {
		return bone.getParent() != null;
	}

	public static software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup getGroupFromHierarchy(RawGeometryTree hierarchy, String bone) {
		HashMap<String, software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup> flatList = new HashMap<>();
		for (software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup group : hierarchy.topLevelBones.values()) {
			flatList.put(group.selfBone.getName(), group);
			traverse(flatList, group);
		}
		return flatList.get(bone);
	}

	public static void traverse(HashMap<String, software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup> flatList, software.bernie.geckolib3.fabric.geo.raw.tree.RawBoneGroup group) {
		for (RawBoneGroup child : group.children.values()) {
			flatList.put(child.selfBone.getName(), child);
			traverse(flatList, child);
		}
	}
}
